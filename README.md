# PlanningPermissionAPI
swagger: "2.0"
info:
  title: "Planning Permission API"
  description: "This API is a resource for County Councils to manage Planning Permission applications for both residential and commericial properties in an efficient manner."
  version: "1.0.0"
host: "localhost:8085"
Access-Control-Allow-Origin: "localhost:8085"
Vary: Origin
Access-Control-Allow-Credentials: true
basePath: "/api"
schemes:
  - http
paths:

  /planningPermissions:
    get:
      tags:
        - "planningPermission"
      summary: "Returns a list of Planning Permission applications"
      description: "This returns a list of all Planning Permission applications available on the system"
      produces:
        - "application/json"
      responses:
        200:
          description: "OK"
        400:
          description: "No Planning Permission Applications have been found."

  /planningPermission/{referenceId}:
    get:
      tags:
        - "planningPermission"
      summary: "Returns a single Planning Permission application"
      description: "This returns a single Planning Permission application matching the referenceId"
      parameters:
        - in: "path"
          name: "referenceId"
          schema:
            type: "integer"
          required: true
          description: "The unique ID for the Planning Permission application."
      produces:
        - "application/json"
      responses:
        200:
          description: "OK"
        400:
          description: "Planning Permission Application does not exist."

    put:
      tags:
        - "planningPermission"
      summary: "Updates an existing Planning Permission application on the system"
      description: "This allows the user to upload a new Planning Permission application to the system."
      parameters:
        - in: "body"
          name: "referenceId"
          schema:
            type: "integer"
          required: true
          description: "The referenceId of the Planning Permission application being updated."
        - in: "body"
          name: "applicantFirstName"
          schema:
            type: "string"
          required: true
          description: "First Name of the Applicant for Planning Permission."
        - in: "body"
          name: "applicantLastName"
          schema:
            type: "string"
          required: true
          description: "Last Name of the Applicant for Planning Permission."
        - in: "body"
          name: "houseArea"
          schema:
            type: "integer"
          required: true
          description: "The House Area of the Planning Permission application."
        - in: "body"
          name: "applicationStatus"
          schema:
            type: "string"
          required: true
          description: "The current progress status of the Planning Permission application."
        - in: "body"
          name: "applicationTypeId"
          schema:
            type: "integer"
          required: true
          description: "The ID for the type of Planning Permission the application is. Use 0 for residential applications and 1 for commericial applications."
      produces:
        - "application/json"
      responses:
        200:
          description: "OK"
        400:
          description: "Planning Permission Application Type does not exist."

    delete:
      tags:
        - "planningPermission"
      summary: "Deletes a Planning Permission application"
      description: ""
      operationId: "deletePlanningPermissionApplication"
      produces:
        - "application/json"
      parameters:
        - name: "referenceId"
          in: "path"
          description: "Planning Permission application referenceId to delete"
          required: true
          type: "integer"
      responses:
        "400":
          description: "Invalid referenceId supplied"
        "404":
          description: "application not found"

  /planningPermissions?applicationTypeId={applicationTypeId}:
    get:
      tags:
        - "planningPermission"
      summary: "Returns a list of Planning Permission applications"
      description: "This returns list of Planning Permission applications matching the ApplicationTypeId. Use 0 for residential applications and 1 for commericial applications."
      parameters:
        - in: "path"
          name: "applicationTypeId"
          schema:
            type: "integer"
          required: true
          description: "The ID for the type of Planning Permission the application is. Use 0 for residential applications and 1 for commericial applications."
      produces:
        - "application/json"
      responses:
        200:
          description: "OK"
        400:
          description: "Planning Permission Application Type does not exist."
  /planningPermission:
    post:
      tags:
        - "planningPermission"
      summary: "Adds a new Planning Permission application to the system"
      description: "This allows the user to upload a new Planning Permission application to the system."
      parameters:
        - in: "body"
          name: "applicantFirstName"
          schema:
            type: "string"
          required: true
          description: "First Name of the Applicant for Planning Permission."
        - in: "body"
          name: "applicantLastName"
          schema:
            type: "string"
          required: true
          description: "Last Name of the Applicant for Planning Permission."
        - in: "body"
          name: "houseArea"
          schema:
            type: "integer"
          required: true
          description: "The House Area of the Planning Permission application."
        - in: "body"
          name: "applicationStatus"
          schema:
            type: "string"
          required: true
          description: "The current progress status of the Planning Permission application."
        - in: "formData"
          name: "applicationTypeId"
          schema:
            type: "integer"
          required: true
          description: "The ID for the type of Planning Permission the application is. Use 0 for residential applications and 1 for commericial applications."
      produces:
        - "application/json"
      responses:
        200:
          description: "OK"
        400:
          description: "Planning Permission Application Type does not exist."
