package game9_12;
// Библиотека
import javax.swing.JOptionPane;

// Класс, запускающий игру
public class Start {
	// Метод, точка входа в игру
	public static void main(String[] args) {
		// Запись значения в переменную из окна
		String rez = JOptionPane.showInputDialog(null,"Введите сложность игры от 1 до 9:","Сложность игры",3);
		// Запись значения сложности в переменную
		int slognost = rez.charAt(0)-'0';
		// Условия, для павильной сложности игры
		if ((slognost>=1) && (slognost<=9))
		{
			// Создаётся объекта класса Okno и в него передатся параметр (переменная) slognost
			Okno wind = new Okno(slognost); 
		}
		else
		{
			// Высвечивается окшко, если сложность введена неравильно!
			JOptionPane.showMessageDialog(null, "ВВЕДИ НОРМАЛЬНУЮ СЛОЖНОСТЬ, ПОЖАЛУЙСТА))", "ОШИБКА", 0);
		}		
	}
}
