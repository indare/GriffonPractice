application {
    title = 'Griffon'
    startupGroups = ['griffon']

    // Should Griffon exit when no Griffon created frames are showing?
    autoShutdown = true

    // If you want some non-standard application class, apply it here
    //frameClass = 'javax.swing.JFrame'
}
mvcGroups {
    // MVC Group for "griffon"
    'griffon' {
        model      = 'griffon.GriffonModel'
        view       = 'griffon.GriffonView'
        controller = 'griffon.GriffonController'
    }

}
