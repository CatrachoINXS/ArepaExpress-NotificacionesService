package com.example.notificaciones_service.infrastructure.in.messaging;

import com.example.notificaciones_service.domain.model.PedidoCreadoEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class NotificacionesListener {

    private static final Logger log = LoggerFactory.getLogger(NotificacionesListener.class);

    @RabbitListener(queues = "notificaciones.pedidos")
    public void avisar(PedidoCreadoEvent pedido) {
        log.info("📲 Hola {}, recibimos tu pedido {}. ¡Ya lo estamos preparando!",
            pedido.cliente(), pedido.pedidoId());
    }
}