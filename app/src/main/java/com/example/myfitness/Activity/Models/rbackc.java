package com.example.myfitness.Activity.Models;

import java.util.ArrayList;

public class rbackc {

    String color[]={"#a4c639","#5227d8","#808080","#846ad4","#5b39c6","#492e9e","#0000ff","#6247b8","#8a2be2","#ec5800","#4f42b5","#af6e4d","#5946b2","#181b26","#6f2da8","#fbcce7","#5218fa","#7d4e2d","#0068ff","#ff6600","#ff0061","#ff00d3"};



    int currnetcolorindex=0;

    public String getcolor(){
        currnetcolorindex=(currnetcolorindex+1) % color.length;
        return color[currnetcolorindex];
    }
}
