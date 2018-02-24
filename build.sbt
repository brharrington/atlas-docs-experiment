lazy val root = (project in file(".")).
  enablePlugins(ParadoxPlugin).
  settings(
    name := "Atlas Docs",
    paradoxTheme := Some(builtinParadoxTheme("generic"))
  )
