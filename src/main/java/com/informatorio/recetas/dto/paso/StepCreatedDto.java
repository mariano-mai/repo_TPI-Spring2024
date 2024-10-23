package com.informatorio.recetas.dto.paso;

import java.util.UUID;

public record StepCreatedDto(UUID id, String descripcion, int tiempoEstimado, boolean esNecesario) {

}
