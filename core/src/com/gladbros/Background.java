package com.gladbros;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;


public class Background  {

    public static int speed = 3;
    private BG [] bgs;

    class BG
    {
        private Texture texture;
        private Vector2 pos;

        public BG (Vector2 pos)
        {
            texture = new Texture("bg.jpg");
            this.pos = pos;
        }
    }


    public Background()
    {
        bgs = new BG[2];
        bgs[0] = new BG(new Vector2(0,0));
        bgs[1] = new BG(new Vector2(800,0));
    }

    public void render(SpriteBatch batch)
    {
        for (int i =0;i < bgs.length; i++){
            batch.draw(bgs[i].texture,bgs[i].pos.x,bgs[i].pos.y);
        }
    }

    public void update(SpriteBatch batch)
    {
        bgs[0].pos.x-= speed;
        bgs[1].pos.x-= speed;
        if(bgs[0].pos.x<-800){
            bgs[0].pos.x = 0;
            bgs[1].pos.x = 800;
        }
    }




}
