<div align="center">

  <h1>notificaciones-service</h1>

  <p align="center">
    <strong>Cristian Camilo Ortiz Sánchez</strong><br />
    DOSW 1 · Semana 14<br />
    Escuela Colombiana de Ingeniería Julio Garavito<br />
    cristian.ortiz-s@mail.escuelaing.edu.co
  </p>

  <p align="center">
    <strong>Arepa Express · API Gateway y RabbitMQ en Azure</strong><br />
    <em>Microservicio que avisa al cliente cuando su pedido fue recibido.</em>
  </p>

</div>

---

## Descripción

- No recibe llamadas HTTP: escucha los eventos desde su propia cola de RabbitMQ.
- Consume los eventos `pedido.creado` desde la cola `notificaciones.pedidos`, unida al exchange `arepas.eventos`.
- Registra en el log el aviso al cliente (simula el envío de una notificación).
- Comparte el exchange con `cocina-service` pero tiene su propia cola, así que un mismo pedido les llega a los dos (comunicación de uno a muchos).
- Su ingress es interno y se mantiene con una réplica siempre encendida.

## Tecnologías

- Java 21
- Spring Boot 3.5.9 (Spring Web, Spring for RabbitMQ)
- Maven
- RabbitMQ
- Docker

## Estructura

```
domain/
└─ model/                PedidoCreadoEvent
infrastructure/
├─ adapter/in/messaging/ NotificacionesListener
└─ config/               RabbitConfig
```

## Contexto

Forma parte de Arepa Express junto con `menu-service`, `pedidos-service` y `cocina-service`.
