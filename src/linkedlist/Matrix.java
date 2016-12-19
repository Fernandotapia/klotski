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
public class Matrix {
     private int Width, Height;
    private Node Reference, RowIterator, ColumnIterator;
   
    public Matrix(int Width, int Height) {
        Reference = new Node();
        this.Width = Width; this.Height = Height;
        RowIterator = ColumnIterator = Reference;
        
        for (int I = 0; I < Height; ++I) {
            for (int J = 0; J < Width; ++J) {
                if (I == 0) {
                    if (J < Width - 1) {
                        RowIterator.Right = new Node();
                        RowIterator.Right.Left = RowIterator;
                        RowIterator = RowIterator.Right;
                    }
                }
                else {  
                    if (J < Width - 1) {
                        if (J == 0) {
                            RowIterator.Up = ColumnIterator;
                        }

                        RowIterator.Right = new Node();
                        RowIterator.Up.Down = RowIterator;
                        RowIterator.Right.Left = RowIterator;
                        RowIterator.Right.Up = RowIterator.Up.Right;
                        RowIterator = RowIterator.Right;
                    }
                }
            }
            
            if (I < Height - 1) {
                ColumnIterator.Down = new Node();
                RowIterator = ColumnIterator = ColumnIterator.Down;
            }
        }
    }
    
    public void SetValue(int X, int Y, int Value) {
        RowIterator = Reference;
        
        for (int I = 0; I < Y; ++I) {
            RowIterator = RowIterator.Down;
        }
        
        for (int J = 0; J < X; ++J) {
            RowIterator = RowIterator.Right;
        }
       
        RowIterator.Value = Value;
    }
    
    public int GetValue(int X, int Y) {
        RowIterator = Reference;
        
        for (int I = 0; I < Y; ++I) {
            RowIterator = RowIterator.Down;
        }
        
        for (int J = 0; J < X; ++J) {
            RowIterator = RowIterator.Right;
        }
        
        return RowIterator.Value;
    }
    
    public void InsertRow(int RowIndex) {
RowIterator = ColumnIterator = Reference;
++Height;
 
for (int I = 0; I < RowIndex; ++I) {
RowIterator = RowIterator.Down;
if (I < RowIndex - 1) {
ColumnIterator = ColumnIterator.Down;
}
}

for (int I = 0; I < Width; ++I){
if (I == 0) {
RowIterator.Up = new Node();
RowIterator.Up.Down = RowIterator;
if (RowIndex == 0) {
Reference = Reference.Up;
}
else {
ColumnIterator.Down = RowIterator.Up;
}
RowIterator = RowIterator.Right;
}
else {
RowIterator.Up = new Node();
RowIterator.Up.Down = RowIterator;
RowIterator.Up.Left = RowIterator.Left.Up;
RowIterator.Up.Left.Right = RowIterator.Up;
RowIterator = RowIterator.Right;
}
}
}
 
public int GetWidth() {
return Width;
}

public int GetHeight() {
return Height;
}
}

