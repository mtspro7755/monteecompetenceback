import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Subscription } from 'rxjs';
import { TranslateService } from '@ngx-translate/core';
import SharedModule from 'app/shared/shared.module';

@Component({
  standalone: true,
  selector: 'm-2-gdil-error',
  templateUrl: './error.component.html',
  imports: [SharedModule],
})
export default class ErrorComponent implements OnInit, OnDestroy {
  errorMessage?: string;
  errorKey?: string;
  langChangeSubscription?: Subscription;

  constructor(
    private translateService: TranslateService,
    private route: ActivatedRoute,
  ) {}

  ngOnInit(): void {
    this.route.data.subscribe(routeData => {
      if (routeData.errorMessage) {
        this.errorKey = routeData.errorMessage;
        this.getErrorMessageTranslation();
        this.langChangeSubscription = this.translateService.onLangChange.subscribe(() => this.getErrorMessageTranslation());
      }
    });
  }

  ngOnDestroy(): void {
    if (this.langChangeSubscription) {
      this.langChangeSubscription.unsubscribe();
    }
  }

  private getErrorMessageTranslation(): void {
    this.errorMessage = '';
    if (this.errorKey) {
      this.translateService.get(this.errorKey).subscribe(translatedErrorMessage => {
        this.errorMessage = translatedErrorMessage;
      });
    }
  }
}
