package griffon

import javax.swing.JOptionPane
import java.awt.Color

class GriffonController {
    // these will be injected by Griffon
    def model
    def view
    def messageService

    def showAbout = { evt = null ->
        messageService.show(
        '''A Function Plotter
that servers as a SwingBuilder exsample for
Groovy in Action''')
    }

    def paintGraph = { evt = null ->
        def calc = new Dynamo(model.function)
        def canvas = view.canvas
        def g = canvas.graphics
        int w = canvas.size.width
        int h = canvas.size.height

        g.color = new Color(255,255,150)
        g.fillRect(0,0,w,h)
        g.color = Color.BLUE

        def dx = (model.to - model.from) / w
        def dy = h / (model.max - model.min)
        int ceiling = h + model.min * dy
        int lastY = calc.f(model.from) * dy

        for (x in (1..w)){
            int y = calc.f(model.from + x * dx) * dy
            g.drawLine(x-1, ceiling - lastY, x, ceiling-y)
            lastY = y
        }
    }

    def showLaf = { evt = null ->
        lookandfeel.instancee.showLafDialog(app)
    }

}

class Dynamo{
    static final GroovyShell SHELL = new GroovyShell()


    Script functionScript

    Dynamo(String function){
        this.functionScript = SHELL.parse('import static java.lang.Math.*;' + function)
    }

    Object f(x){
        functionScript.x = x
        return functionScript.run()
    }

}