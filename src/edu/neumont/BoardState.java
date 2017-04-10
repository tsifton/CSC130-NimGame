package edu.neumont;

/**
 * Created by Trevor on 4/7/2017.
 */
public class BoardState {

    public BoardState(int[] rows){
        this.rows = rows;
    }

    public BoardState(int[] rows, float weight)
    {
        this.rows = rows;
        this.weight = weight;
    }

    public int[] rows;
    public float weight = 0.0f;
}
