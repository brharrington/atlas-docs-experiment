
import java.util.Base64

import akka.http.scaladsl.model.Uri
import com.lightbend.paradox.markdown.ContainerBlockDirective
import com.lightbend.paradox.markdown.Directive
import com.lightbend.paradox.markdown.Writer
import com.netflix.atlas.config.ConfigManager
import com.netflix.atlas.core.db.DataSet
import com.netflix.atlas.core.db.StaticDatabase
import com.netflix.atlas.core.util.PngImage
import com.netflix.atlas.eval.graph.Grapher
import com.typesafe.config.ConfigFactory
import org.pegdown.Printer
import org.pegdown.ast.DirectiveNode
import org.pegdown.ast.Visitor

object GraphDirective extends ContainerBlockDirective("atlas-graph") with (Writer.Context => Directive) {
  private val config = ConfigFactory.load(getClass.getClassLoader)
  ConfigManager.set(config)

  private val db = new StaticDatabase(config.getConfig("atlas.core.db"))
  private val grapher = Grapher(config)

  def apply(context: Writer.Context): Directive = GraphDirective

  def render(node: DirectiveNode, visitor: Visitor, printer: Printer): Unit = {
    val uri = Uri(node.contents.trim)
    val image = grapher.render(uri, db)
    val meta = PngImage(image.data)
    val width = meta.data.getWidth
    val height = meta.data.getHeight

    val encoded = Base64.getEncoder.encodeToString(image.data)
    val dataUri = s"data:image/png;base64,$encoded"

    printer.print(s"""<image src="$dataUri" alt="$uri" width="$width" height="$height"/>""")
  }
}
