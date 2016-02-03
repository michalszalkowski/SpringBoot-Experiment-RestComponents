package pl.btbw.web.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.btbw.core.common.Component;
import pl.btbw.core.common.Link;
import pl.btbw.core.product.core.Product;
import pl.btbw.core.product.core.ProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class ProductController {

	@Autowired
	private ProductRepository productRepository;

	// temporary solution
	@RequestMapping(value = {"/component/product"})
	public List<Link> links() {
		List<Link> links = new ArrayList<>();
		links.add(new Link("http://localhost:8095/component/product/{id}/author"));
		links.add(new Link("http://localhost:8095/component/product/{id}/brand"));
		links.add(new Link("http://localhost:8095/component/product/{id}/info"));
		links.add(new Link("http://localhost:8095/component/product/{id}/all"));
		links.add(new Link("http://localhost:8095/component/product/{id}/all/MAP"));
		return links;
	}

	@RequestMapping(value = {"/component/product/{id}/author"})
	public Component componentAuthor(@PathVariable("id") long id) {
		return productRepository.getOne(id)
				.componentProvider()
				.authorProductComponent()
				.buildOne();
	}

	@RequestMapping(value = {"/component/product/{id}/brand"})
	public Component componentBrand(@PathVariable("id") long id) {
		return productRepository.getOne(id)
				.componentProvider()
				.brandProductComponent()
				.buildOne();
	}

	@RequestMapping(value = {"/component/product/{id}/info"})
	public Component componentInfo(@PathVariable("id") long id) {
		return productRepository.getOne(id)
				.componentProvider()
				.infoProductComponent()
				.buildOne();
	}

	@RequestMapping(value = {"/component/product/{id}/all"})
	public List<Component> componentAll(@PathVariable("id") long id) {
		return productRepository.getOne(id)
				.componentProvider()
				.brandProductComponent()
				.infoProductComponent()
				.authorProductComponent()
				.buildList();
	}

	@RequestMapping(value = {"/component/product/{id}/all/MAP"})
	public Map<String, Component> componentAllMap(@PathVariable("id") long id) {
		return productRepository.getOne(id)
				.componentProvider()
				.brandProductComponent()
				.infoProductComponent()
				.authorProductComponent()
				.buildMap();
	}

}
