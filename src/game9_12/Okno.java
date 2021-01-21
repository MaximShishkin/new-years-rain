package game9_12;

//Библиотеки
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

// Класс Okno, в котором создаётся окно игры
public class Okno extends JFrame{
	
    // Объект класса Pole c именем game_Pole
	private Pole game_Pole;
	
	// Класс для обработки нажатия клавиш на клавиатуре 
	private class MyKey implements KeyListener
	{
		// Срабатывает при нажатии на клавишу
		public void keyPressed(KeyEvent arg0) {
			// Запись кода клавиши в переменную
			int key_code = arg0.getKeyCode();
			// Вывод значения в консоль 
			System.out.println(key_code);
			if (key_code==37) // движение шапки влево 
			{
				game_Pole.x= game_Pole.x - 30;
			}
			if (key_code==39) // движение шапки вправо
			{
				game_Pole.x= game_Pole.x + 30;
			}
			if (game_Pole.x>751) 
			{
				game_Pole.x=0;
			}
			if (game_Pole.x<0) 
			{
				game_Pole.x=750;
			}
		}
		public void keyReleased(KeyEvent arg0) {}
		public void keyTyped(KeyEvent arg0) {}	
	}
	
	// Конструктор класса Okno, в который передаём переменную slognost
	Okno(int slognost)
	{
		// Прикрепляем обработчик клавиш клавиватуры к окну
		addKeyListener(new MyKey());
		setFocusable(true);
		
		// Создаём размеры окна и пишем надпись в шапку окна
		setBounds(10,10,800,600);
		setTitle("Игра - новогодний дождь. Сложность " + slognost);
		
		// Создаём объект класса Pole и прикрепляем к окну
		game_Pole = new Pole(slognost);
		add(game_Pole);
		
		// Очищаем память компьютера при закрытии окна и делаем окно видимым
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
