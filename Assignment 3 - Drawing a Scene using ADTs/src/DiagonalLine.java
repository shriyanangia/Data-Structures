import bridges.base.Color;
import bridges.base.ColorGrid;

public class DiagonalLine extends Mark
{
    private int x1;
    private int y1;
    private int x2;
    private int y2;

    public DiagonalLine(int x1, int y1, int x2, int y2, Color color)
    {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.color = color;
    }


    @Override
    //this code is derived from https://www.geeksforgeeks.org/bresenhams-line-generation-algorithm/

    public void draw(ColorGrid cg)
    {
        int m_new = 2 * (y2 - y1);
        int slope_error_new = m_new - (x2 - x1);

        for (int x = x1, y = y1; x <= x2; x++)
        {
            cg.set(y,x,color);

            // Add slope to increment angle formed
            slope_error_new += m_new;

            // Slope error reached limit, time to
            // increment y and update slope error.
            if (slope_error_new >= 0)
            {
                y++;
                slope_error_new -= 2 * (x2 - x1);
            }
        }
    }
}
