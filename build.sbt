lazy val root = (project in file(".")).
  enablePlugins(ParadoxMaterialThemePlugin).
  settings(
    name := "Atlas Docs",
    paradoxDirectives += StacklangDirective,
    paradoxGroups := Map(
      "Language" -> Seq("Java", "JavaScript", "Go", "Python", "Ruby")
    )
  )
