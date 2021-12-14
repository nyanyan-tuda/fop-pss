public Point(Point point){
    x=point.x;
    y=point.y;
    }

public Point copy(){
    return new Point(this);
    }
