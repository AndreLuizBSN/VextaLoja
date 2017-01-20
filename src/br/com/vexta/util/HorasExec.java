package br.com.vexta.util;

import java.text.DecimalFormat;
import java.util.Calendar;

import javax.swing.JLabel;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.util.Duration;

public class HorasExec {
	
	JLabel jLabel;
	Label label;
	

	//declarando variáveis
	int hh,mm,ss; //*
	Calendar hora; //*Hora
	DecimalFormat formato; //*
	
	public HorasExec(Label label) {
		this.label = label;
		Timeline timeline = new Timeline(new KeyFrame(
				Duration.millis(1000),
		        ae -> HORAS()));
		timeline.setCycleCount(Animation.INDEFINITE);
		timeline.play();
	}
	
	private void HORAS(){
		hora = Calendar.getInstance();
		hh = hora.get(Calendar.HOUR_OF_DAY);
		mm = hora.get(Calendar.MINUTE);
		
		/*if(this.jLabel != null) {
			this.jLabel.setText(formatar(hh)+":"+formatar(mm)+":"+formatar(ss));
		}*/
		if(this.label != null) {
			this.label.setText(formatar(hh)+":"+formatar(mm));
		}
	
	}
	
	private String formatar(int num){
		formato = new DecimalFormat("00");
		return formato.format(num);
	}
	
}
