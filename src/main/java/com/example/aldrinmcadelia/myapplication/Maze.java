package com.example.aldrinmcadelia.myapplication;

import android.graphics.Canvas;
import android.graphics.Paint;

public class Maze {
    private int Row=1;
    private int Column=1;
    private int[] walls;
    private final int offset=10;
    private int Size=0;
    private int top=0,
            left=0,
            bottom=0,
            right=0;

    public void setSize(int x,int y)
    {
        Row=y;
        Column=x;
    }

    public void setWindow(int height, int width) {
        Size=(height-2*getOffset())/Column>(width-2*getOffset())/Row?(width-2*getOffset())/Row:(height-2*getOffset())/Column;
    }

    public void createMaze(int height, int width){
        createWalls();
        calculateSize(height,width);
    }

    public void createWalls()
    {
        DisjSets maze=new DisjSets(Row*Column);
        walls =new int[Row*Column];

        for (int i=0;i<Row*Column;i++)
        {
            if (i/Column==0)
            {
                if (i%Column==0)
                    walls[i]=0;
                else
                    walls[i]=1;
            }
            else
            {
                if(i%Column==0)
                    walls[i]=2;
                else
                    walls[i]=3;
            }
        }



        int counter=Row*Column-1;

        while(counter!=0)
        {
            System.out.println("counter"+counter);

            int index= (int)(Math.random()*Column*Row);

            System.out.println("index"+index);

            switch(walls[index])
            {
                case 0:
                    break;

                case 1:
                    if (maze.find(index)!=maze.find(index-1))
                    {
                        maze.union(maze.find(index),maze.find(index-1));
                        counter--;
                        walls[index]-=1;

                    }
                    break;

                case 2:
                    if (maze.find(index)!=maze.find(index-Column))
                    {
                        maze.union(maze.find(index),maze.find(index-Column));
                        counter--;
                        walls[index]-=2;

                    }
                    break;

                case 3:
                    if (Math.random()>0.5)
                    {
                        if (maze.find(index)!=maze.find(index-1))
                        {
                            maze.union(maze.find(index),maze.find(index-1));
                            counter--;
                            walls[index]-=1;

                        }
                        break;
                    }
                    else
                    {
                        if (maze.find(index)!=maze.find(index-Column))
                        {
                            maze.union(maze.find(index),maze.find(index-Column));
                            counter--;
                            walls[index]-=2;

                        }
                        break;
                    }
            }
        }
    }

    public void calculateSize(int height, int width){
        top=0+getOffset();
        left=(height-Size*Column-2*getOffset())/2+getOffset();// y direction
        bottom=Size*Row+top;
        right=Size*Column+left;
    }

    public int getwalls(int x)
    {
        return walls[x];
    }

    public int getRow()
    {
        return Row;
    }

    public int getColumn()
    {
        return Column;
    }

    public int getSize() {
        return Size;
    }

    public int getTop() {
        return top;
    }

    public int getLeft() {
        return left;
    }

    public int getBottom() {
        return bottom;
    }

    public int getRight() {
        return right;
    }

    public int getOffset() {
        return offset;
    }

    class DisjSets
    {
        public DisjSets( int numElements )
        {
            s = new int [ numElements ];
            for( int i = 0; i < s.length; i++ )
                s[ i ] = -1;
        }


        public void union( int root1, int root2 )
        {
            s[ root2 ] = root1;
        }

        public int find( int x )
        {
            if( s[ x ] < 0 )
                return x;
            else
                return find( s[ x ] );
        }

        private int [] s;
    }

    public void drawMaze(Canvas canvas, Paint mPaint){
        for(int i=0;i<Row*Column;i++)
        {
            int x=Size*(i/Column)+top;
            int y= Size*(i%Column)+left;
            switch(getwalls(i))
            {
                case 0:
                    break;

                case 1:
                    canvas.drawLine(x,y,x+Size,y, mPaint);
                    canvas.save();
                    break;

                case 2:
                    canvas.drawLine(x,y,x,y+Size, mPaint);
                    canvas.save();
                    break;

                case 3:
                    canvas.drawLine(x,y,x,y+Size, mPaint);
                    canvas.save();
                    canvas.drawLine(x,y,x+Size,y, mPaint);
                    canvas.save();
                    break;
            }

        }


        canvas.drawLine(top,left,top,right, mPaint);
        canvas.save();
        canvas.drawLine(top,left,bottom,left, mPaint);
        canvas.save();
        canvas.drawLine(bottom,left,bottom,right-Size, mPaint);
        canvas.save();
        canvas.drawLine(top,right,bottom-Size,right, mPaint);
        canvas.save();
        canvas.restore();
    }
}

