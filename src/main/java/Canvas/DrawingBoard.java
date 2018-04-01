package Canvas;

import java.util.Optional;

public class DrawingBoard {

    private Integer length;
    private Integer height;
    private Optional<DrawingPoint>[][] drawingArea;

    public DrawingBoard(Integer length, Integer height) {
        this.length = length;
        this.height = height;
        this.drawingArea = new Optional[this.height + 2][ this.length + 2];
    }

    public void setPoint(DrawingPoint dp) {
        this.drawingArea[dp.Y][dp.X] = Optional.ofNullable(dp);
    }

    public Optional<DrawingPoint> getDrawingPoint(int x, int y){
        return this.drawingArea[y][x];
    }

    public Integer getLength(){
        return this.length;
    }


    public Integer getHeight() {
        return this.height;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int y =0 ;y< drawingArea.length; y++) {

            if(sb.length() != 0) {
                sb.append("\n");
            }
            for(int x =0; x<drawingArea[y].length; x++) {
                if(this.drawingArea[y][x] != null && this.drawingArea[y][x].isPresent()) {
                    sb.append(this.drawingArea[y][x].get().getDrawingChar());
                }
                else
                {
                    sb.append(' ');
                }
            }
        }

        return sb.toString();
    }
}
