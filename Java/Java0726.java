package Java;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Java0726 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int[][] board = new int[19][19];
        String str = "";
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 19; i++) {
            str = in.readLine();
            st = new StringTokenizer(str, " ");
            for (int j = 0; j < 19; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[] dx = { 1, 0, 1, 1 };
        int[] dy = { -1, 1, 1, 0 };
        int win = 0;
        int resultI;
        int resultJ;
        // 1이 검정, 2가 희색
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {

                if (board[i][j] == 1) {
                    for (int k = 0; k < 4; k++) {
                        // 방향을 찾고
                        int directX = i + dy[k];
                        int directY = j + dx[k];
                        if(directX<0 || directX>=19 || directY<0 || directY>=19)
                            continue;
                        if (board[directX][directY] == 1) {
                            int black = 1;
                            // 해당 방향으로
                            for (int l = 1; l <= 4; l++) {
                                int ny = i + dy[k] * l;
                                int nx = j + dx[k] * l;
                                if (ny < 0 || ny >= 19 || nx < 0 || nx >= 19)
                                    continue;
                                if (board[ny][nx] == 1) {
                                    black++;
                                }

                            }

                            if (black == 5) {
                                win = 1;
                                resultI = i + 1;
                                resultJ = j + 1;
                                System.out.println(win);
                                System.out.println(resultI + " " + resultJ);
                                return;
                            }
                        }
                    }
                }
                if (board[i][j] == 2) {
                    for (int k = 0; k < 4; k++) {
                        // 방향을 찾고
                        int directX = i + dy[k];
                        int directY = j + dx[k];
                        if(directX<0 || directX>=19 || directY<0 || directY>=19)
                            continue;
                        if (board[directX][directY] == 2) {
                            int white = 1;
                            // 해당 방향으로
                            for (int l = 1; l <= 3; l++) {
                                int ny = i + dy[k] * l;
                                int nx = j + dx[k] * l;
                                if (ny < 0 || ny >= 19 || nx < 0 || nx >= 19)
                                    continue;
                                if (board[ny][nx] == 2) {
                                    white++;
                                }
                            }
                            if (white == 5) {
                                win = 2;
                                resultI = i + 1;
                                resultJ = j + 1;
                                System.out.println(win);
                                System.out.println(resultI + " " + resultJ);
                                return;
                            }
                        }
                    }
                }

            }
        }
        System.out.println(win);
    }
}
