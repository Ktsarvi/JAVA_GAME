package world;

import graphics.Assets;
import utils.Constants;
import java.awt.Color;
import java.awt.Graphics2D;

public class TileManager {

    public static final int FLOOR = 0;
    public static final int WALL = 1;
    public static final int DOOR_TILE = 2;

    private int[][] tiles;
    private int cols, rows;

    public TileManager(int cols, int rows) {
        this.cols = cols;
        this.rows = rows;
        this.tiles = new int[rows][cols];
        buildWalls();
    }

    private void buildWalls() {
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (r == 0 || r == rows - 1 || c == 0 || c == cols - 1) {
                    tiles[r][c] = WALL;
                } else {
                    tiles[r][c] = FLOOR;
                }
            }
        }
    }

    public void setTile(int col, int row, int type) {
        if (row >= 0 && row < rows && col >= 0 && col < cols) {
            tiles[row][col] = type;
        }
    }

    public int getTile(int col, int row) {
        if (row >= 0 && row < rows && col >= 0 && col < cols) {
            return tiles[row][col];
        }
        return WALL;
    }

    public boolean isSolid(int col, int row) {
        return getTile(col, row) == WALL;
    }

    public boolean isSolidAtPixel(int px, int py) {
        int col = px / Constants.TILE_SIZE;
        int row = py / Constants.TILE_SIZE;
        return isSolid(col, row);
    }

    public void draw(Graphics2D g) {
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                int px = c * Constants.TILE_SIZE;
                int py = r * Constants.TILE_SIZE;

                switch (tiles[r][c]) {
                    case WALL:
                        if (Assets.wallTile != null) {
                            g.drawImage(Assets.wallTile, px, py, Constants.TILE_SIZE, Constants.TILE_SIZE, null);
                        } else {
                            g.setColor(new Color(45, 35, 30));
                            g.fillRect(px, py, Constants.TILE_SIZE, Constants.TILE_SIZE);
                            g.setColor(new Color(55, 45, 35));
                            g.drawRect(px + 1, py + 1, Constants.TILE_SIZE - 2, Constants.TILE_SIZE - 2);
                            // Brick pattern
                            g.setColor(new Color(60, 50, 40));
                            g.drawLine(px, py + Constants.TILE_SIZE / 2, px + Constants.TILE_SIZE, py + Constants.TILE_SIZE / 2);
                            g.drawLine(px + Constants.TILE_SIZE / 2, py, px + Constants.TILE_SIZE / 2, py + Constants.TILE_SIZE / 2);
                            g.drawLine(px + Constants.TILE_SIZE / 4, py + Constants.TILE_SIZE / 2, px + Constants.TILE_SIZE / 4, py + Constants.TILE_SIZE);
                            g.drawLine(px + 3 * Constants.TILE_SIZE / 4, py + Constants.TILE_SIZE / 2, px + 3 * Constants.TILE_SIZE / 4, py + Constants.TILE_SIZE);
                        }
                        break;
                    case FLOOR:
                    default:
                        if (Assets.floorTile != null) {
                            g.drawImage(Assets.floorTile, px, py, Constants.TILE_SIZE, Constants.TILE_SIZE, null);
                        } else {
                            // Alternating stone floor pattern
                            boolean dark = (r + c) % 2 == 0;
                            g.setColor(dark ? new Color(70, 62, 55) : new Color(80, 72, 65));
                            g.fillRect(px, py, Constants.TILE_SIZE, Constants.TILE_SIZE);
                            g.setColor(new Color(60, 52, 45));
                            g.drawRect(px, py, Constants.TILE_SIZE, Constants.TILE_SIZE);
                        }
                        break;
                }
            }
        }
    }

    public int getCols() { return cols; }
    public int getRows() { return rows; }
}
