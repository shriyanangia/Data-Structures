import bridges.base.Color;
import bridges.base.ColorGrid;

public class Circle extends Mark
{
    private int r;
    private int x_centre;
    private int y_centre;

    public Circle(int r, int x_centre, int y_centre, Color color)
    {
        this.r = r;
        this.x_centre = x_centre;
        this.y_centre = y_centre;
        this.color = color;
    }

    @Override
    //this code is derived from https://www.geeksforgeeks.org/mid-point-circle-drawing-algorithm/

    public void draw(ColorGrid cg)
    {
        int x = r, y = 0;

        // Printing the initial point
        // on the axes after translation
        cg.set(y + y_centre, x + x_centre, color);

        // When radius is zero only a single
        // point will be printed
        if (r > 0)
        {
            cg.set(-y + y_centre, x + x_centre, color);

            cg.set(x + y_centre, y + x_centre, color);

            cg.set(x + y_centre, -y + x_centre, color);
        }

        // Initialising the value of P
        int P = 1 - r;
        while (x > y)
        {
            y++;

            // Mid-point is inside or on the perimeter
            if (P <= 0) {
                P = P + 2 * y + 1;
            }

            // Mid-point is outside the perimeter
            else {
                x--;
                P = P + 2 * y - 2 * x + 1;
            }

            // All the perimeter points have already
            // been printed
            if (x < y) {
                break;
            }

            // Printing the generated point and its
            // reflection in the other octants after translation

            cg.set(y + y_centre, x + x_centre, color);

            cg.set(y + y_centre, -x + x_centre, color);

            cg.set(-y + y_centre, x + x_centre, color);

            cg.set(-y + y_centre, -x + x_centre, color);

            // If the generated point is on the
            // line x = y then the perimeter points
            // have already been printed
            if (x != y)
            {
                cg.set(x + y_centre, y + x_centre, color);

                cg.set(x + y_centre, -y + x_centre, color);

                cg.set(-x + y_centre, y + x_centre, color);

                cg.set(-x + y_centre, -y + x_centre, color);
            }
        }
    }
}
