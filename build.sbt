lazy val root = (project in file("."))
  .enablePlugins(ParadoxSitePlugin, ParadoxMaterialThemePlugin)
  .settings(
    name := "Atlas Docs",
    paradoxDirectives += StacklangDirective,
    paradoxGroups := Map(
      "Language" -> Seq("Java", "JavaScript", "Go", "Python", "Ruby")
    ),
    ParadoxMaterialThemePlugin.paradoxMaterialThemeSettings(Paradox),
    paradoxMaterialTheme in Paradox ~= {
      _.withFavicon("images/atlas_logo_small.png")
        .withLogo("images/atlas_logo_small.png")
        .withRepository(uri("https://github.com/brharrington/atlas-docs"))
    },
    sourceDirectory in Paradox := sourceDirectory.value / "main" / "paradox",
    previewFixedPort := Some(8000), // Match mkdocs default
    previewLaunchBrowser := false
  )
