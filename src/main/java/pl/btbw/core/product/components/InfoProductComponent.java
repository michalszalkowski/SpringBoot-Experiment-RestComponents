package pl.btbw.core.product.components;

import pl.btbw.core.common.Component;

import java.math.BigDecimal;

public class InfoProductComponent extends Component {

	private final Long id;
	private final String name;
	private final BigDecimal price;

	public InfoProductComponent(Long id, String name, BigDecimal price) {
		this._nameComponent = "InfoProductComponent";
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public BigDecimal getPrice() {
		return price;
	}
}
