class Robot {
    int width;
    int height;
    int perimeter;
    int pos;
    boolean moved;

    public Robot(int width, int height) {
        this.width = width;
        this.height = height;
        this.perimeter = 2 * (width + height) - 4;
        this.pos = 0;
        this.moved = false;
    }
    
    public void step(int num) {
        pos = (pos + num) % perimeter;
        moved = true;
    }
    
    public int[] getPos() {
        int p = pos;
        if(p < width){
            return new int[]{p,0};
        }
        p -=(width-1);

        if(p < height){
            return new int[]{width-1,p};
        }
        p -= (height-1);

        if(p < width){
            return new int[]{width-1-p,height-1};
        }
        p -= (width - 1);
        return new int[]{0,height-1-p};
    }
    
    public String getDir() {
        if(pos == 0 && moved) return moved ? "South": "East";
        int p = pos;
        if(p < width) return "East";
        if(p < width + height-1) return "North";
        if(p < 2 * width + height-2) return "West";
        return "South";   
    }
}

/**
 * Your Robot object will be instantiated and called as such:
 * Robot obj = new Robot(width, height);
 * obj.step(num);
 * int[] param_2 = obj.getPos();
 * String param_3 = obj.getDir();
 */