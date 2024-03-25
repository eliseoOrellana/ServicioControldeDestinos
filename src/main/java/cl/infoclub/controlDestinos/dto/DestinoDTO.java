package cl.infoclub.controlDestinos.dto;

import java.util.List;
import cl.infoclub.controlDestinos.entity.Destino;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
public class DestinoDTO extends GenericDTO{

	
	List<Destino> destino;

	public DestinoDTO(String mensaje, String codigo,List<Destino> destino) {
		super(mensaje, codigo);
		this.destino=destino;
		// TODO Auto-generated constructor stub
	}
		
}
