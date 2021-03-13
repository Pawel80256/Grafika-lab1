# Grafika-lab1
Projekt przedstawia prostą grafikę/animację stworzoną za pomocą Javy.

## Aplikacja składa się z trzech klas:
* Main
* MyFrame
* GraphicsDemo

## Main
Stworzenie obiektu klasy MyFrame
```
class Main
{
    public static void main(String[] args) {
        MyFrame myFrame = new MyFrame();
    }
}
```


## MyFrame
Rozszerzenie JFrame, ustawienie podstawowych parametrów okna graficznego
```
import javax.swing.*;

public class MyFrame extends JFrame {

    GraphicsDemo graphicsDemo = new GraphicsDemo();

    public MyFrame()
    {
        this.setSize(800,900);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(graphicsDemo);
        this.setVisible(true);
    }
}

```

## GraphicsDemo
Klasa "główna", zawierająca kod opisujący wszystkie figury, kształty i animacje.
* Pola, konstruktor,timer, oraz funkcja ładująca zdjęcie
```
    int angle=180;
    private  Image image;
    
    GraphicsDemo()
    {
        timer.start();
        loadImage();
    }

    void loadImage()
    {
        image = new ImageIcon("MonaLisa.jpg").getImage();
    }
    
    Timer timer = new Timer(50,this);
```
## Funkcja paintComponent rysująca podane kształty w oknie graficznym, kolejno:
* Wstawienie zdjęcia jpg:
```
        g.drawImage(image,20,20,160,270,null);
        g2d.setColor(Color.black);
        g2d.setStroke(new BasicStroke(2));
        g2d.drawRect(20,20,160,270);
```
* Okno:
```
        //niebo
        g2d.setColor(new Color(51,153,255));
        g2d.fillRect(450,75,250,250);
        //trawa za oknem
        g2d.setColor(Color.green);
        int[] grassXPoints = {580,620,640,680,700,700,580,580};
        int[] grassYPoints = {280,262,273,250,275,325,325,280};
        g2d.fillPolygon(grassXPoints,grassYPoints,8);
        //okno
        g2d.setColor(Color.white);
        g2d.setStroke(new BasicStroke(3));
        int[] windowXPoints={450,700,700,450,450};
        int[] windowYPoints={75,75,325,325,75};
        g2d.drawPolyline(windowXPoints,windowYPoints,5);
        g2d.drawLine(576,75,576,325);
        g2d.drawLine(450,200,700,200);
        g2d.setColor(Color.yellow);
        g2d.fillOval(610,80,80,80);
        g2d.setColor(Color.white);
        g2d.fillOval(470,100,30,30);
        g2d.fillOval(480,103,30,30);
        g2d.fillOval(495,100,30,30);
        g2d.fillOval(505,104,30,30);
```
* Biurko:
```
        //biurko
        int[] tableXpoints = {50,20,730,700};
        int[] tableYpoints = {450,625,625,450};
        g2d.setColor(new Color(153,102,0));
        g2d.fillPolygon(tableXpoints,tableYpoints,4);
        //nozki
        int[] nozka1X = {20,28,42,50};
        int[] nozka1Y = {625,825,825,625};
        int[] nozka2X = {700,708,722,730};
        int[] nozka2Y = {625,825,825,625};
        int[] nozka3X = {80,88,102,110};
        int[] nozka3Y = {625,725,725,625};
        int[] nozka4X = {640,648,662,670};
        int[] nozka4Y = {625,725,725,625};

        g2d.setColor(new Color(153,102,0));
        g2d.fillPolygon(nozka1X,nozka1Y,4);
        g2d.fillPolygon(nozka2X,nozka2Y,4);
        g2d.fillPolygon(nozka3X,nozka3Y,4);
        g2d.fillPolygon(nozka4X,nozka4Y,4);

        g2d.setColor(new Color(102,51,0));
        g2d.drawPolyline(nozka1X,nozka1Y,4);
        g2d.drawPolyline(nozka2X,nozka2Y,4);
        g2d.drawPolyline(nozka3X,nozka3Y,4);
        g2d.drawPolyline(nozka4X,nozka4Y,4);

        //obwodka biurka
        g2d.setColor(new Color(102,51,0));
        g2d.setStroke(new BasicStroke(4));
        int[] tableXpoints2 = {50,20,730,700,50};
        int[] tableYpoints2 = {450,625,625,450,450};
        g2d.drawPolyline(tableXpoints2,tableYpoints2,5);
```

* Monitor, drzewo fraktalne
```
        //wypelnienie monitora
        g2d.setColor(Color.black.brighter().brighter().brighter().brighter().brighter().brighter().brighter().brighter());
        g2d.fillRect(154, 229, 442, 292);
        g2d.setColor(Color.GREEN);
        g2d.setStroke(new BasicStroke(2));
        
        //drzewo
        makeTree(50,0,375,515,g);

        //korekta
        g2d.setColor(new Color(153,102,0));
        g2d.fillRect(150,525,450,90);
        //podstawka
        g2d.setColor(Color.black.brighter().brighter().brighter().brighter().brighter().brighter().brighter().brighter());
        int[] standXPoints = {348, 331, 419, 402};
        int[] standYPoints = {555, 575, 575, 555};
        g2d.fillPolygon(standXPoints, standYPoints, 4);
        //monitor
        int[] monitorXPoints = {150, 600, 600, 150, 150};
        int[] monitorYPoints = {225, 225, 525, 525, 225};
        g2d.setColor(Color.black);
        g2d.setStroke(new BasicStroke(8));
        g2d.drawPolyline(monitorXPoints, monitorYPoints, 5);
        g2d.fillRect(368, 525, 14, 40);

        this.setBackground(Color.gray);
```

* "Dywan":

```
        g2d.setStroke(new BasicStroke(2));
        g2d.setColor(Color.blue);
        int[] dywanXPoints = {172,222,272,322,372,422,472,522,572,
                                542,572,542,572,
                                522,472,422,372,322,272,222,172
                                ,202,172,202,172};
        int[] dywanYPoints = {680,650,680,650,680,650,680,650,680,
                                710,740,770,800,
                                830,800,830,800,830,800,830,800,
                                770,740,710,680};
        g2d.drawPolyline(dywanXPoints,dywanYPoints,25);

        GradientPaint gradientPaint = new GradientPaint(0,0,new Color(102,0,190),600,0,new Color(204,0,0));
        g2d.setPaint(gradientPaint);
        g2d.fillPolygon(dywanXPoints,dywanYPoints,25);
```
## Funkcja rysująca rekursywnie drzewo fraktalne:
```
    public void makeTree(int length, int angle, int x, int y, Graphics g){

        g.setColor(Color.GREEN);
        int xmove = (int)(Math.cos(Math.toRadians(angle+90))* length);
        int ymove = (int)(Math.sin(Math.toRadians(angle-90))* length);
        g.drawLine(x,y,x+xmove,y+ymove);

        if(length>=1)
        {
            makeTree(length-5,angle+this.angle,x+xmove,y+ymove,g);
            makeTree(length-5,angle-this.angle,x+xmove,y+ymove,g);
        }
    }
```
## Funkcja zapewniająca animację drzewa po włączeniu programu:
```
  @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
        if(angle>25)
        this.angle--;

    }
```
