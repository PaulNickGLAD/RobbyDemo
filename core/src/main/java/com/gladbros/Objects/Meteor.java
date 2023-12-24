package main.java.com.gladbros.Objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import main.java.com.gladbros.TextFields.Timer;

import java.util.Random;

public class Meteor{

    public Meteor(){
        texture = new Texture("Meteor.jpg");
        pos = new Vector2[3];
        pos[0] = new Vector2(800, 200 + (new Random().nextInt(200) + 10));
        pos[1] = new Vector2(1000, 100 + (new Random().nextInt(240) + 48));
        pos[2] = new Vector2(1300, 150 + (new Random().nextInt(200) + 48));
    }

    Texture texture;
    public static Vector2 [] pos;
    public static int speed = 12;

    public void render(SpriteBatch batch)
    {
        for (int i = 0; i < pos.length; i++)
        {
          batch.draw(texture, pos[i].x,pos[i].y);
        }
    }

    public void update(SpriteBatch batch) {
        for (int i =0; i < pos.length; i++)
        {
            pos[i].x -= speed;
            //Speedup function
            if(Timer.seconds == 40 && Timer.miliseconds == 1){
                speed += 2;
            }
            if(pos[i].x <= 0)
            {
                pos[i].x = 800 + new Random().nextInt(85);
                if (i > 0){
                    if ((pos[i].x - pos[i-1].x) < 82 && (pos[i].y - pos[i-1].y ) < 82){
                        pos[i].x += 82;
                        pos[i].y += 82;
                    }
                }
                pos[i].y = 0 + new Random().nextInt(200) + new Random().nextInt(150)+15;
            }
        }
    }
}