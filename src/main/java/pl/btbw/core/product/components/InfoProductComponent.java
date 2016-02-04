package pl.btbw.core.product.components;

import pl.btbw.core.common.output.Component;

import java.math.BigDecimal;

public class InfoProductComponent extends Component {

	public final Long id;
	public final String name;
	public final BigDecimal price;

	public InfoProductComponent(Long id, String name, BigDecimal price) {
		this._nameComponent = "InfoProductComponent";
		this.id = id;
		this.name = name;
		this.price = price;
	}
}
