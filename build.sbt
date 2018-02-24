lazy val root = (project in file(".")).
  enablePlugins(ParadoxMaterialThemePlugin).
  settings(
    name := "Atlas Docs",
    paradoxDirectives += StacklangDirective
  )
