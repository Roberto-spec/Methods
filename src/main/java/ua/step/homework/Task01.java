package ua.step.homework;

/**
 * Написать и методы работы с квадратными матрицами (матрицы
 * представить в виде двухмерных массивов). 
 * Должны присутствовать методы:
 * • создания единичной (диагональной) матрицы (метод createOne)
 * • создания нулевой матрицы (метод createNull)
 * • сложение матриц (метод sumMatrix)
 * • умножения матриц (метод productMatrix)
 * • умножение матрицы на скаляр (метод productMatrix)
 * • определение детерминанта матрицы (метод determinant)
 * • вывод матрицы на консоль (метод printMatrix)
 */
public class Task01 {

	public static void main(String[] args) {
		// TODO: Проверяйте методы здесь
	}

	/**
	 * Создает единичную матрицу
	 * @param n - количество строк
	 * @param m - количество колонок
	 * @return единичную (диагональную) матрицу
	 */
	public static int[][] createOne (int n, int m) {
		// TODO: удалите исключение и пишите здесь код
		int[][] mss=new int[n][m];
		int y=0;
		for (int i=0; i<n;i++){
			if(y<m) {
				mss[i][y] = 1;
				y++;
			}
			else break;

		}
		return mss;
	}

	/**
	 * Создает нулевую матрицу
	 * @param n - количество строк
	 * @param m - количество колонок
	 * @return нулевую матрицу
	 */
	public static int[][] createNull (int n, int m) {
		// TODO: удалите исключение и пишите здесь код
		int[][] mss=new int[n][m];
		for (int i=0; i<n;i++){
			for (int y=0; y<m;y++){
				mss[i][y]=0;
			}
		}

		return mss;
	}

	/**
	 * Вычисляет сумму двух матриц
	 * @param one - первая матрица
	 * @param two - вторая матрица
	 * @return сумму двух матриц
	 */
	public static int[][] sumMatrix(int[][] one, int[][] two) {
		// TODO: удалите исключение и пишите здесь код

		int[][] mss=new int[one.length][one[0].length];
		for (int i=0; i<one.length;i++){
			for (int y=0; y<one[0].length;y++){
				mss[i][y]=one[i][y]+two[i][y];
			}
		}

		return mss;

	}

	/**
	 * Вычисляет произведение двух матриц
	 * @param one - первая матрица
	 * @param two - вторая матрица
	 * @return произведение матриц
	 */
	public static int[][] productMatrix(int[][] one, int[][] two) {
		int[][] mss=new int[one.length][two[0].length];
		for (int i=0; i<one.length; ++i)
			for (int j=0; j<two[0].length; ++j)
				for (int k=0; k<two.length; ++k)
					mss[i][j] += one[i][k] * two[k][j];

		return mss;
	}

	/**
	 * Вычисляет произведение матрицы на скаляр
	 * @param matrix - матрица
	 * @param num - скаляр
	 * @return произведение матрицы на скаляр
	 */
	public static int[][] productMatrix(int[][] matrix, int num) {
		int[][] mss=new int[matrix.length][matrix[0].length];
		for (int i=0; i<matrix.length;i++){
			for (int y=0; y<matrix[0].length;y++){
				mss[i][y]=matrix[i][y]*num;
			}
		}

		return mss;
	}

	/**
	 * Вычисляет детерминант матрицы
	 * @param matrix - матрица
	 * @return детерминант матрицы
	 */
	public static int determinant(int[][] matrix) {
		int n = matrix.length;
		if(n == 1) return matrix[0][0];
		int ans = 0;
		int B[][] = new int [n-1][n-1];
		int l = 1;
		for(int i = 0; i < n; ++i){

			int x = 0, y = 0;
			for(int j = 1; j < n; ++j){
				for(int k = 0; k < n; ++k){
					if(i == k) continue;
					B[x][y] = matrix[j][k];
					++y;
					if(y == n - 1){
						y = 0;
						++x;
					}
				}
			}
			ans += l * matrix[0][i] * determinant(B);
			l *= (-1);
		}
		return ans;
	}

	/**
	 * Печатает матрицу в стандартный поток вывода
	 * @param matrix - матрица
	 */
	public static void printMatrix(int[][] matrix) {
		for (int i=0; i<matrix.length;i++){
			for (int y=0; y<matrix[0].length;y++){
				System.out.print(matrix[i][y]+" ");
			}
			System.out.println();
		}
	}
}
