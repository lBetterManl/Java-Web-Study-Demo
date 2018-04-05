package cn.test.demo;

public class Demo01 {
/*输出如下结果
	 	3	7
	   2 4 6 8
	  1   5   9
	平面图形  （二维数组）画图找规律
*/
	
	public static void main(String[] args) {
		
		int num = 13;
		
		int height = num/4+1;
		int width = num;
		
		int arr[][] = new int[height][width];
		
		int x = height-1;
		int y = 0;
		
		boolean order = false;
		for(int i=1;i<=num;i++){
			arr[x][y] = i;
			y++;
			
			if (order==false) {
				x--;
			}
			if (order==true) {
				x++;
			}
			
			if (x<0) {
				order = true;
				x = x+2;
			}
			if (x>height-1) {
				order = false;
				x = x-2;
			}
		}
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j]==0) {
					System.out.print(" ");
				}else{
					System.out.print(arr[i][j]);
				}
			}
			System.out.println();
		}
		
	}

}
