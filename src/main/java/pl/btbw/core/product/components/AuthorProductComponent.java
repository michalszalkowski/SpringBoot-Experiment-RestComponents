package pl.btbw.core.product.components;

import pl.btbw.core.common.output.Component;

public class AuthorProductComponent extends Component {

	public final Long id;
	public final String index;
	public final String author;

	public AuthorProductComponent(Long id, String index, String author) {
		this._nameComponent = "AuthorProductComponent";
		this.id = id;
		this.index = index;
		this.author = author;
	}
}
