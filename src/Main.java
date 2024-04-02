import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       // test1();
        createFrog();
        createPoint();
        ifGrassHopperIsAlive();
    }

    public static void test1 ()
    {
        Frog testFrog = new Frog(new Point(0, 0), 1);
        Frog testFrog2 = new Frog(0, 0, 100);
        int n = 3;
        Point[] route = new Point[n];   //создался массив, НО не точек
        //а указателей на точки
        route[0] = new Point(2, 0);
        route[1] = new Point(1, 1);
        route[2] = new Point(0, 1);

        for (int i = 0; i < route.length; i++) {
            double d = Point.calcDistance(testFrog.place, route[i]);
            if( d<= testFrog.tongueLength)
            {
                System.out.println("кузнечек съеден в "+(i+1) +" точке");
                break;
            }
        }
    }
    public static Frog createFrog(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите значения координат и длину языка: ");
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int len = scanner.nextInt();
        Frog testFrog2 = new Frog(x, y, len);
        return testFrog2;
    }
    public static Point[] createPoint(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите длину маршрута: ");
        int n = scanner.nextInt();
        Point[] route = new Point[n];
            for (int i=0; i<n;i++) {
                System.out.println("Введите координаты точек: ");
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                route[i] = new Point(x, y);
            }
            return route;
    }
    public static void ifGrassHopperIsAlive(){
        int n = createPoint().length;
        Point[] route = new Point[n];
        for (int i = 0; i < createPoint().length; i++) {
            double d = Point.calcDistance(createFrog().place, route[i]);
            System.out.println("Расстояние равно: "+d);
            if( d<= createFrog().tongueLength )
            {
                System.out.println("кузнечек съеден в "+(i+1) +" точке");
                break;
            }
        }
    }
}

class Point{
    int x,y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
        System.out.println("вызван конструктор точки с параметрами "+x+"; "+y);
    }

    public static double calcDistance(Point p1, Point p2){
        return Math.sqrt((p1.x-p2.x)*(p1.x-p2.x)+(p1.y-p2.y)*(p1.y-p2.y));
    }
}

class Frog{
    Point place;
    int tongueLength;

    public Frog(Point place, int tongueLength) {
        this.place = place;
        this.tongueLength = tongueLength;
        System.out.println("вызван конструктор Frog с 2 параметрами");
    }

    public Frog(int x, int y, int len){
        place = new Point(x, y);
        tongueLength = len;
        System.out.println("вызван конструктор Frog с 3 параметрами");
    }
}