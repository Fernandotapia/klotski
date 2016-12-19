/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlist;

/**
 *
 * @author Fernando
 */
public class Node {
public Node Up, Down, Left, Right;
 public int Value;
 
    public Node() {
        Value = -1;
        Up = Down = Left = Right = null;
    }
}
