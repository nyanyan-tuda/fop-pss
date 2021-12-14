public Robot(int x,int y){
    super(x,y);
    setGlobalWorld();

    world.checkXCoordinate(x);
    world.checkYCoordinate(y);

    world.addRobot(this);
    }
