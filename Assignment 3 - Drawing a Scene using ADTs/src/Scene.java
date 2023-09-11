
import java.util.LinkedList;

import bridges.base.ColorGrid;
import bridges.base.Color;


public class Scene
{

    /* Creates a Scene with a maximum capacity of Marks and
	   with a background color.
	   maxMarks: the maximum capacity of Marks
	   backgroundColor: the background color of this Scene
     */
	private Color bgColour;
	private LinkedList<Mark> marksArr;

	public Scene(Color backgroundColor)
	{
		this.bgColour = backgroundColor;
		marksArr = new LinkedList<Mark>();
	}

	/* Adds a Mark to this Scene. When drawn, the Mark
	   will appear on top of the background and previously added Marks
	   m: the Mark to add
	 */
	public void addMark(Mark m)
	{
		marksArr.add(m);
	}

	/*
	Helper method: deletes the Mark at an index.
	If no Marks have been previously deleted, the method
	deletes the ith Mark that was added (0 based).
	i: the index
	 */
	protected void deleteMark(int i)
	{
		marksArr.remove(i);
	}

	/*
	Deletes all Marks from this Scene that
	have a given Color
	c: the Color
	 */
	public void deleteMarksByColor(Color c)
	{
		for (int i=0; i<marksArr.size(); i++)
		{
			if (marksArr.get(i) != null)
			{
				if (marksArr.get(i).isColor(c))
				{
					deleteMark(i);
				}
			}
		}
	}

	/* draws the Marks in this Scene over a background color
	   onto a ColorGrid. Marks will appear on top of the
	   background, and Marks will overlap other Marks if
	   they were added by a more recent call to addMark.
	   cg: the ColorGrid to draw on
	 */
	public void draw(ColorGrid cg)
	{
		int yCoordinate = cg.getHeight();
		int xCoordinate = cg.getWidth();
		for (int i=0; i<xCoordinate;i++)
		{
			for (int j=0; j<yCoordinate;j++)
			{
				cg.set(j, i, bgColour);
			}
		}
		for (int i=0; i<marksArr.size();i++)
		{
				marksArr.get(i).draw(cg);
		}
	}
};
