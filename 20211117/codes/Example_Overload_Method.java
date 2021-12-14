public Point copy(){
    return new Point(x,y);
    }

public Point[]copy(int n){
    Point[]copies=new Point[n];
    for(int i=0;i<copies.length;i++){
    copies[i]=new Point(x,y);
    }
    return copies;
    }
