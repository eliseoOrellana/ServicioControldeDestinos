package cl.infoclub.controlDestinos.dto;

import java.util.List;
import cl.infoclub.controlDestinos.entity.Pasajero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
public class PasajeroDTO extends GenericDTO {
	
	List<Pasajero> pasajero;

	public PasajeroDTO(String mensaje, String codigo,List<Pasajero> pasajero) {
		super(mensaje, codigo);
		this.pasajero=pasajero;//constructor del super padre
		// TODO Auto-generated constructor stub
	}
	
	

}


