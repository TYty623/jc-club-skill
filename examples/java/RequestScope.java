package examples;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Immutable request context created only after server-side authentication.
 * The gateway or auth service should verify a token before constructing it.
 */
public record RequestScope(String requestId, String principalId, Set<String> roles) {
    public RequestScope {
        requestId = required(requestId, "requestId");
        principalId = required(principalId, "principalId");
        roles = Set.copyOf(Objects.requireNonNull(roles, "roles"));
    }

    public static RequestScope fromVerifiedClaims(
            String requestId, String principalId, Collection<String> verifiedRoles) {
        Objects.requireNonNull(verifiedRoles, "verifiedRoles");
        Set<String> normalizedRoles = new LinkedHashSet<>();
        for (String role : verifiedRoles) {
            normalizedRoles.add(required(role, "role"));
        }
        return new RequestScope(requestId, principalId, normalizedRoles);
    }

    public boolean hasRole(String role) {
        return roles.contains(required(role, "role"));
    }

    private static String required(String value, String field) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(field + " must not be blank");
        }
        return value.trim();
    }
}
