package game9_12;

// Библиотеки
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import java.awt.Graphics;

public class Podarok {
	Image img; // картинка
	int x,y; // координаты
	Boolean active_img; // загружена картинка на экран или нет
	Timer TimerUpdate;  // таймер
	int slognost; // сложность
	int updatespeed=0;
	
	// Конструктор класса
	Podarok (Image img, int slognost)
	{
		TimerUpdate = new Timer(500, new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// вызываем метод для движения подарка вниз
				vniz();
			}
		});
		
		this.slognost=slognost;
		this.img=img;
		active_img = false;
	}
	
	// метод активации подарка на игровом поле
	void start()
	{
		TimerUpdate.start(); // запукает таймер
		y=0; // начальная кордината y для подарка
		x=(int)(Math.random()*700); // начальная случайная координата x
		active_img=true; // картинка выведена на экран
	}
	
	// метод для движения картинки с подарком вниз
	void vniz()
	{
		if (active_img==true)
		{
			y=y+10+slognost*2+updatespeed; // если картинка выведена на экран, то меняется координата y
		}
		if ((y+img.getHeight(null))>=470) // условие окончания игры
		{
			TimerUpdate.stop(); // завершение работы таймера
		}
	}
	
	// метод выполняющий отрисовку
	void draw(Graphics g)
	{
		if (active_img==true) // если картинка выведена на экран, то
		{
			g.drawImage(img, x, y, null); // то рисуем
		}
	}
}
