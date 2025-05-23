import { Component, Input } from '@angular/core';
import TranslateDirective from '../language/translate.directive';

/**
 * A component that will take care of item count statistics of a pagination.
 */
@Component({
  standalone: true,
  selector: 'm-2-gdil-item-count',
  template: ` <div m2GdilTranslate="global.item-count" [translateValues]="{ first: first, second: second, total: total }"></div> `,
  imports: [TranslateDirective],
})
export default class ItemCountComponent {
  /**
   * @param params  Contains parameters for component:
   *                    page          Current page number
   *                    totalItems    Total number of items
   *                    itemsPerPage  Number of items per page
   */
  @Input() set params(params: { page?: number; totalItems?: number; itemsPerPage?: number }) {
    if (params.page && params.totalItems !== undefined && params.itemsPerPage) {
      this.first = (params.page - 1) * params.itemsPerPage + 1;
      this.second = params.page * params.itemsPerPage < params.totalItems ? params.page * params.itemsPerPage : params.totalItems;
    } else {
      this.first = undefined;
      this.second = undefined;
    }
    this.total = params.totalItems;
  }

  first?: number;
  second?: number;
  total?: number;
}
