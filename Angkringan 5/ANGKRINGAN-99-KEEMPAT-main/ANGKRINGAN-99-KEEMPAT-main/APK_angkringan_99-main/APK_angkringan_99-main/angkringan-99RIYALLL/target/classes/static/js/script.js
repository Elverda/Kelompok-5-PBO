 // Script untuk menangani transisi antara login dan register
      const registerToggleBtn = document.getElementById("register-toggle-btn");
      const loginToggleBtn = document.getElementById("login-toggle-btn");
      const formsContainer = document.querySelector(".forms-container");

      registerToggleBtn.addEventListener("click", () => {
        formsContainer.classList.add("register-mode");
      });

      loginToggleBtn.addEventListener("click", () => {
        formsContainer.classList.remove("register-mode");
      });