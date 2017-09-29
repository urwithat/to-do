import { Injectable, Inject, EventEmitter } from '@angular/core';
import { Http } from '@angular/http';
import 'rxjs/add/operator/map';

@Injectable()
export class TaskService {
  
  taskUpdatedEvent: EventEmitter<any> = new EventEmitter();

  constructor(public http: Http) {
  }

  create(title, description, status) {
    let data = {
      "id": null,
      "title": title,
      "description": description,
      "status": status,
      "dateTime": Date.parse(Date())/1000
    }
    return this.http.post("/api/tasks/create", data)
      .map(response => response.json())
  }

  readAll() {
    return this.http.get("/api/tasks")
      .map(response => response.json())
  }

  update(id, title, description, status, dateTime) {
    let data = {
      "id": id,
      "title": title,
      "description": description,
      "status": status,
      "dateTime": dateTime
    }
    return this.http.put("/api/tasks/update", data)
      .map(response => response.json())
  }
  
  updateStatus(id, status) {
    let data = {
      "id": id,
      "status": status
    }
    return this.http.put("/api/tasks/update/status", data)
      .map(response => response.json())
  }

  delete(id) {
    return this.http.get("/api/tasks/delete/" + id)
      .map(response => response.json())
  }

  readByStatus(status) {
    return this.http.get("/api/tasks/status/" + status)
      .map(response => response.json())
  }
  
}