document.addEventListener("DOMContentLoaded", () => {
  const params = new URLSearchParams(window.location.search);
  if (params.get("success") === "1") {
    const message = document.getElementById("successMessage");
    if (message) {
      message.hidden = false;
      message.textContent = "Registration saved successfully! Open Admin records to view it.";
    }
    history.replaceState({}, document.title, window.location.pathname + "#register");
  }

  document.querySelectorAll("[data-event]").forEach(link => {
    link.addEventListener("click", () => {
      const eventSelect = document.getElementById("eventName");
      if (eventSelect) eventSelect.value = link.dataset.event;
    });
  });
});
