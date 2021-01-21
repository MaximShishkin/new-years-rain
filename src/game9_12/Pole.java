package game9_12;

//Библиотеки
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.Graphics;

public class Pole extends JPanel{

	private Image shapka; // картинка шапки
	private Image fon; // картинка фона
	private Image end_game; // картинка конца игры
	int x = 400; // Движение шапки
	// массив с объектами подарков (картинками)
	private int schet=0; // счётчик для количетва пойманных шапок
	private int hp=3; // количество попыток в игре
	private Podarok [] game_Podarok = new  Podarok [9]; // в нём будут храниться 7 значений с с индексами (от 0 до 6)
	Timer TimerUpdate, TimerDraw; // таймеры
	private int slognost; // значение сложности
	
	// Конструктор класса Pole, в который передаём переменную slognost (сложность)
	Pole(int slognost)
	{
		this.slognost=slognost;
		
		try {
			game_Podarok[0]=new Podarok(ImageIO.read(this.getClass().getResource("p0.png")),slognost);
			game_Podarok[1]=new Podarok(ImageIO.read(this.getClass().getResource("p1.png")),slognost);
			game_Podarok[2]=new Podarok(ImageIO.read(this.getClass().getResource("p2.png")),slognost);
			game_Podarok[3]=new Podarok(ImageIO.read(this.getClass().getResource("p3.png")),slognost);
			game_Podarok[4]=new Podarok(ImageIO.read(this.getClass().getResource("p4.png")),slognost);
			game_Podarok[5]=new Podarok(ImageIO.read(this.getClass().getResource("p5.png")),slognost);
			game_Podarok[6]=new Podarok(ImageIO.read(this.getClass().getResource("p6.png")),slognost);
			game_Podarok[7]=new Podarok(ImageIO.read(this.getClass().getResource("p2.png")),slognost);
			game_Podarok[8]=new Podarok(ImageIO.read(this.getClass().getResource("p3.png")),slognost);
			
			shapka=ImageIO.read(this.getClass().getResource("shapka.png"));
			fon = ImageIO.read(this.getClass().getResource("fon.png"));
			end_game = ImageIO.read(this.getClass().getResource("end_game.png"));
			
			System.out.println("С картинками всё ок");
		} catch (IOException e) {
			System.out.println("Ошибка с картинками");
		}	
		
		TimerUpdate = new Timer(1000, new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UpdateStart();
				repaint();
			}
		});
		TimerUpdate.start();
		
		TimerDraw = new Timer(50, new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				repaint();
			}
		});
		TimerDraw.start();	
	}
	
	// считает кол-во картинок на поле и  если их значение меньше значения сложности, то добавляет картинку на экран
	private void UpdateStart() 
	{
		int koll=0; // переменная, которая показывает количесвто картинок на поле в данный момент
		
		for (int i=0;i<9;i++) // цикл по всем картинкам
		{
			if(game_Podarok[i].active_img==false) // если картинка не добавлена на экран, то 
			{
				if (koll<slognost) // если количесвто картинок на поле меньше выбранной сложности игры, то
				{
					game_Podarok[i].start(); // запускается картинка на экран
					break; // выходим из цикла
				}
			}
			else koll++; // фиксируем, что картинка уже есть на экране
		}
	}
	
	// Отрисовывает графику в окне
	public void paintComponent(Graphics gr)
	{
		super.paintComponent(gr); // 
		// отрисовка фона
		gr.drawImage(fon, 0, 0, null);
		
		// цикл отрисовки картинок
		for (int i=0;i<9;i++)
		{
			// вызов метода для отрисовки, который находится в классе Podarok
			game_Podarok[i].draw(gr);
			// условие проверики, если картинка есть на поле, то
			if (game_Podarok[i].active_img==true)
			{
				if((game_Podarok[i].y+game_Podarok[i].img.getHeight(null))>=470)
				{
					if (Math.abs(game_Podarok[i].x-x)>75)
					{
						if (hp==0) { // Если попыток не осталось, то заканчиваем игру!
							gr.drawImage(end_game, 300, 300, null);
							TimerUpdate.stop();
							TimerDraw.stop();
							break;
						}
						
						hp=hp-1; // Уменьшаем кол-во попыток на 1
						game_Podarok[i].active_img=false; // убираем подарок с поля
					}
					else
					{
						game_Podarok[i].active_img=false; // убираем подарок с поля
						schet=schet+1; // Набиваем счётчик
						if (schet % 10 == 0) // деление с остатком, если остаток 0, то
						{
							for (int j=0;j<9;j++) // применяем изменение скорости ко всем подаркам
							{
								game_Podarok[j].updatespeed=game_Podarok[j].updatespeed+10;
							}
						}
					}
				}	
			}	
		}
		gr.setColor(Color.white);
		gr.drawString("Счёт игры: "+ schet, 700, 10);
		gr.drawString("Осталось попыток: "+ hp, 652, 30);
		gr.drawImage(shapka, x, 465,null);
	}
}
