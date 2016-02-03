package pl.btbw.core.product;

import pl.btbw.core.common.output.ComponentProvider;
import pl.btbw.core.product.components.AuthorProductComponent;
import pl.btbw.core.product.components.BrandProductComponent;
import pl.btbw.core.product.components.InfoProductComponent;
import pl.btbw.core.product.core.Product;

public class ProductComponentProvider extends ComponentProvider {

	private Product product;

	public ProductComponentProvider(Product product) {
		this.product = product;
	}

	public ProductComponentProvider authorProductComponent() {
		add(new AuthorProductComponent(
				product.getId(),
				product.getIndex(),
				product.getAuthor()
		));
		return this;
	}

	public ProductComponentProvider brandProductComponent() {
		add(new BrandProductComponent(
				product.getId(),
				product.getSlug(),
				product.getBrand(),
				product.getDescription()
		));
		return this;
	}

	public ProductComponentProvider infoProductComponent() {
		add(new InfoProductComponent(
				product.getId(),
				product.getName(),
				product.getPrice()
		));
		return this;
	}
}
