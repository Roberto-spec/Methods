package ua.step.homework;
import java.util.Scanner;
/**
 * В этом задании нет заготовленных методов.
 * Продумайте их самостоятельно.
 *
 * Королю нужно убить дракона, но в его казне мало средств
 * для покупки армии. Нужно создать программу, используя
 * методы, которая поможет рассчитать минимальное ко-
 * личество копейщиков, которое необходимо, чтобы убить
 * дракона. C клавиатуры вводятся данные:
 * - здоровья дракона;
 * - атаки дракона;
 * - здоровье одного копейщика;
 * - атака одного копейщика.
 * Защита, меткость и т. п. не учитывать. Копейщики наносят
 * удар первыми (общий нанесенный урон – это сумма атак
 * всех живых копейщиков). Если атака дракона превышает
 * значение жизни копейщика (например, у копейщика жиз-
 * ни – 10, а атака – 15), то умирает несколько копейщиков, а
 * оставшийся урон идет одному из копейщиков.
 *
 * Например, жизнь дракона – 500, атака – 55, жизнь одно-
 * го копейщика – 10, атака –10, а количество копейщиков при
 * данных условиях – 20.
 * Лог боя для данного примера должен выглядеть так:
 *
 * Итерация 15
 * Копейщики атакуют (урон 200) – у дракона осталось 300 жизней
 * Дракон атакует – осталось 15 копейщиков, один из которых ранен
 * (осталось 5 жизней)
 * Копейщики атакуют – у дракона осталось 150 жизней
 * Дракон атакует – осталось 9 копейщиков
 * Копейщики атакуют – у дракона осталось 60 жизней
 * Дракон атакует – осталось 4 копейщика, один из которых ранен
 * (осталось 5 жизней)
 * Копейщики атакуют – у дракона осталось 20 жизней
 * Дракон атакует и побеждает
 *
 *
 */
class Combat_unit{
	int hp;
	int atk;

	Combat_unit() {
		this.hp=0;
		this.atk=0;
	}
	Combat_unit(int hp,int atk) {
		this.hp=hp;
		this.atk=atk;
	}
	void sethp( int hp){
		this.hp=hp;
	}
	void setatk( int atk){
		this.atk=atk;
	}
	int getHp(){
		return hp;
	}
	int getAtk(){
		return atk;
	}

}
class Army{
	int cout;
	Combat_unit[] Kozak=new Combat_unit[50];
	Army( int count, int atk,int hp){
		this.cout=count;
		for (int i=0;i<count;i++){
			Kozak[i] = new Combat_unit(hp,atk);
		}
	}
	int attack(){
		int dmg;
		dmg=cout*Kozak[0].getAtk();
		return dmg;
	}
	void enemydmg(Combat_unit Dragon){
		cout=cout- (Dragon.getAtk()/Kozak[0].getHp());
		if(cout>0)Kozak[cout-1].sethp(Kozak[cout-1].getHp()-((Dragon.getAtk()%(Kozak[0].getHp()))));

	}
}

public class Task05 {
	public static void main(String[] args) {
		// TODO: проверяйте ваш код здесь
		int hp = 0;
		int atk = 0;
		Scanner in = new Scanner(System.in);
		System.out.println("Pls enter hp dragon:");
		System.out.print("<");
		hp = in.nextInt();
		System.out.println("Pls enter atk dragon:");
		System.out.print("<");
		atk = in.nextInt();
		Combat_unit Dragon = new Combat_unit(hp, atk);
		System.out.println("Pls enter hp kozak:");
		System.out.print("<");
		hp = in.nextInt();
		System.out.println("Pls enter atk kozak:");
		System.out.print("<");
		atk = in.nextInt();
		Army army = new Army(20,atk,hp);

		while (true){
			Dragon.sethp(Dragon.getHp()- army.attack());
			System.out.print("Kozaks has been attak(dmg "+ army.attack() +") - ");
			if(Dragon.getHp()<=0){
				System.out.println(" Dragon died!");
				break;
			}
			else{
				System.out.println("Dragon have "+Dragon.getHp());
			}
			army.enemydmg(Dragon);
			System.out.print("Dragon has been attak(dmg "+ Dragon.getAtk() +") - ");
			if(army.cout<=0){
				System.out.println(" ALL kozaks died!");
				break;
			}
			else if (army.Kozak[army.cout-1].getHp()<hp){
				System.out.println("Left "+army.cout +" Kozaks but 1 Kozak have blood and he have "+army.Kozak[army.cout-1].getHp()+" hp");
			}
			else{
				System.out.println("Left "+army.cout +" Kozaks");
			}

		}


	}
}


