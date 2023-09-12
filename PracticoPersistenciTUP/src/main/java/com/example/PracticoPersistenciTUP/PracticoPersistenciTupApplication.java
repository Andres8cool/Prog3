package com.example.PracticoPersistenciTUP;

import com.example.PracticoPersistenciTUP.Enumeration.Estado;
import com.example.PracticoPersistenciTUP.Enumeration.FormadePago;
import com.example.PracticoPersistenciTUP.Enumeration.TipodeEnvio;
import com.example.PracticoPersistenciTUP.Enumeration.TipodeProducto;
import com.example.PracticoPersistenciTUP.entidades.*;
import com.example.PracticoPersistenciTUP.repositorios.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.ArrayList;
import java.util.Arrays;

@SpringBootApplication
public class PracticoPersistenciTupApplication {
	@Autowired
	ClienteRepositorio clienteRepositorio;
	@Autowired
	DetallePedidoRepositorio detallePedidoRepositorio;
	@Autowired
	DomicilioRepositorio domicilioRepositorio;
	@Autowired
	FacturaRepositorio facturaRepositorio;
	@Autowired
	PedidoRepositorio pedidoRepositorio;
	@Autowired
	ProductoRepositorio productoRepositorio;
	@Autowired
	RubroRepositorio rubroRepositorio;
	@Autowired
	UsuarioRepositorio usuarioRepositorio;

	public static void main(String[] args) {
		SpringApplication.run(PracticoPersistenciTupApplication.class, args);


		System.out.println("funcionando...   :) ");


	}

	@Bean
	@Transactional
	public CommandLineRunner init(UsuarioRepositorio usuarioRepositorio, PedidoRepositorio pedidoRepositorio, DetallePedidoRepositorio detallePedidoRepositorio, RubroRepositorio rubroRepositorio, DomicilioRepositorio domicilioRepositorio, ClienteRepositorio clienteRepositorio) {
		return args -> {

// Crear usuario
		Usuario usuario1 = Usuario.builder()
				.nombre("usuario123")
				.password("clave123")
				.rol("cliente")
				.build();
		usuarioRepositorio.save(usuario1);

// Crear rubro
		Rubro rubro1 = Rubro.builder().denominacion("Pizzeria").build();
		rubroRepositorio.save(rubro1);

// Crear cliente
		Cliente cliente1 = Cliente.builder()
				.nombre("Ana")
				.apellido("González")
				.numeroTelefono("987654321")
				.correoElectronico("ana@gmail.com")
				.pedidos(new ArrayList<>())
				.build();
		clienteRepositorio.save(cliente1);

// Crear productos
		Producto producto1 = Producto.builder()
				.tipodeProducto(TipodeProducto.MANUFACTURADO)
				.tiempoEstimadoCocina(15)
				.denominacion("Pizza Margarita")
				.precioVenta(12.0)
				.precioCompra(5.0)
				.stockActual(30)
				.stockMinimo(10)
				.unidadMedida("unidad")
				.foto("pizza.jpg")
				.receta("receta")
				.build();
		productoRepositorio.save(producto1);

		Producto producto2 = Producto.builder()
				.tipodeProducto(TipodeProducto.INSUMO)
				.tiempoEstimadoCocina(10)
				.denominacion("Salsa de Tomate")
				.precioVenta(3.0)
				.precioCompra(1.0)
				.stockActual(50)
				.stockMinimo(20)
				.unidadMedida("litro")
				.foto("salsa.jpg")
				.receta("receta")
				.build();
		productoRepositorio.save(producto2);

// Asociar productos al rubro
		rubro1.agregarProducto(producto1);
		rubro1.agregarProducto(producto2);
		rubroRepositorio.save(rubro1);

// Crear domicilio para el cliente
		Domicilio domicilioCliente1 = Domicilio.builder()
				.calle("Calle Principal")
				.numero("123")
				.localidad("Ciudad")
				.cliente(cliente1)
				.build();
		domicilioRepositorio.save(domicilioCliente1);

// Crear pedido
		Pedido pedido1 = Pedido.builder()
				.fecha("2023-09-15")
				.horaEstimadaEntrega("19:30")
				.estado(Estado.ENTREGADO)
				.tipodeEnvio(TipodeEnvio.DELIVERY)
				.total(20.0)
				.build();

		domicilioCliente1.getPedidos().add(pedido1);
		pedidoRepositorio.save(pedido1);
		domicilioRepositorio.save(domicilioCliente1);
		usuario1.getPedidos().add(pedido1);
		usuarioRepositorio.save(usuario1);

// Crear detalle de pedido
		DetallePedido detallePedido1 = DetallePedido.builder()
				.cantidad(3)
				.subtotal(36.0)
				.producto(producto1)
				.build();
		pedido1.setDetallesPedido(Arrays.asList(detallePedido1));

		cliente1.getPedidos().add(pedido1);
		clienteRepositorio.save(cliente1);

// Crear factura
		Factura factura1 = Factura.builder()
				.fecha("2023-09-15")
				.numero(2)
				.descuento(2.0)
				.formadePago(FormadePago.EFECTIVO)
				.total(18.0)
				.build();

		pedido1.setFactura(factura1);
		facturaRepositorio.save(factura1);
		pedidoRepositorio.save(pedido1);



    };

}
}