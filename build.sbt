lazy val root = (project in file("."))
  .enablePlugins(ParadoxSitePlugin, ParadoxMaterialThemePlugin)
  .settings(
    name := "Atlas Docs",
    paradoxDirectives += StacklangDirective,
    ParadoxMaterialThemePlugin.paradoxMaterialThemeSettings(Paradox),
    paradoxMaterialTheme in Paradox ~= {
      _.withFavicon("src/main/paradox/images/atlas_logo_small.png")
        .withLogo("src/main/paradox/images/atlas_logo_small.png")
        .withRepository(uri("https://github.com/brharrington/atlas-docs"))
    },
    sourceDirectory in Paradox := sourceDirectory.value / "main" / "paradox",
    previewFixedPort := Some(8000), // Match mkdocs default
    previewLaunchBrowser := false
  )
