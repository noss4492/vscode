package makePainter;

import java.awt.Canvas;
import java.io.Serializable;

public class PaintPacket extends Canvas implements Serializable{
	CreateDrawCanvas cdc; 
	Canvas canvas;
	
	
	public PaintPacket() {
	}

	public PaintPacket(CreateDrawCanvas cdc) {
		this.cdc = cdc;
		cdc = new CreateDrawCanvas();
		cdc.getDrawCanvas();
	}

	public PaintPacket(Canvas canvas) {
		super();
		this.canvas = canvas;
	}
	
	

}
