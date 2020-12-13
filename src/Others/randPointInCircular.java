package Others;

/*
    给定圆的半径和圆心的 x、y 坐标，写一个在圆中产生均匀随机点的函数 randPoint 。
 */
public class randPointInCircular {
    public static void main(String[] args) {
        System.out.println(Math.sin(Math.PI / 6));
    }

    double radius;
    double x_point;
    double y_point;

    public randPointInCircular(double radius, double x_center, double y_center) {
        this.radius = radius;
        this.x_point = x_center;
        this.y_point = y_center;
    }

    public double[] randPoint() {
        double x_min = x_point - radius;
        double y_min = y_point - radius;
        double x_random = 0;
        double y_random = 0;
        double distance = radius + 1;
        while (distance > radius) {
            x_random = x_min + Math.random() * radius * 2;
            y_random = y_min + Math.random() * radius * 2;
            distance = Math.sqrt((Math.pow(x_random - x_point, 2) + Math.pow(y_random - y_point, 2)));
        }
        return new double[]{x_random, y_random};
    }

    public double[] randPoint2() {
        double len = Math.sqrt(Math.random() * radius * radius); //生成点与圆心的随机距离，此种形式才能保证产生均匀的随机点
        double angle = Math.random() * 2 * Math.PI;
        double x_random = x_point + len * Math.sin(angle);
        double y_random = y_point + len * Math.cos(angle);
        return new double[]{x_random, y_random};
    }
}
